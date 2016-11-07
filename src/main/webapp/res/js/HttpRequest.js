function HttpRequest(url, method) {
    this.request = new XMLHttpRequest();
    this.url = url;
    this.method = method;
}

HttpRequest.GET = "GET";
HttpRequest.POST = "POST";

HttpRequest.prototype.setBody = function (body) {
    if(typeof body === 'object') 
        body = JSON.stringify(body);
    
    this.body = body;
    return this;
};

HttpRequest.prototype.successHandler = function (handler) {
    if(typeof handler != 'function') return;
    
    this.successHandler = handler;
    return this;
};

HttpRequest.prototype.errorHandler = function (handler) {
    if(typeof handler != 'function') return;
    
    this.errorHandler = handler;
    return this;
};

HttpRequest.prototype.send = function () {
    var httpRequest = this;
    
    this.request.addEventListener("load", function () {
        var xmlHttpRequest = this;
        if (xmlHttpRequest.status == 200) {
            httpRequest.successHandler(xmlHttpRequest.responseText);
        } else {
            httpRequest.errorHandler(xmlHttpRequest.responseText);
        }
    });
    
    httpRequest.request.open(httpRequest.method, httpRequest.url, true);
    httpRequest.request.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
    httpRequest.request.send(httpRequest.body);
    return this;
};
