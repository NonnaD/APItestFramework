public class StatusCodeDecoder {

    public static String statusCode(Integer statusCode){
        String response = null;
        switch (statusCode){
           // 1×× Informational
            case 100:
                response = "Continue";
                break;
            case 101:
                response = "Switching Protocols";
                break;
            case 102:
                response= "Processing";
                break;
            //2×× Success

            case 200:
                response= "OK";
                break;
            case 201:
                response = "Created";
                break;
            case 202:
                response = "Accepted";
            case 203:
                response = "Non-authoritative Information";
                break;
            case 204:
                response = "No Content";
                break;
            case 205:
                response = "Reset Content";
                break;

            case 206:
                response= "Partial Content";
                break;
            case 207:
                response = "Multi-Status";
                break;
            case 208:
                response = "Already Reported";
                break;
            case 226:
                response = "IM Used";
                break;
            //3×× Redirection
            case 300:
                response = "Multiple Choices";
                break;
            case 301:
                response = "Moved Permanently. URI of the requested resource has been changed. Probably, the new URI would be given in the response.";
                break;
            case 302:
                response = "Found. URI of requested resource has been changed temporarily. New changes in the URI might be made in the future. Therefore, this same URI should be used by the client in future requests.";
                break;
            case 303:
                response = "See Other.The server sent this response to direct the client to get the requested resource at another URI with a GET request.";
                break;
            case 304:
                response= "Not Modified.the response has not been modified, so the client can continue to use the same cached version of the response.";
                break;
            case 305:
                response= "Use Proxy. A requested response must be accessed by a proxy";
                break;
            case 307:
                response="Temporary Redirect";
                break;
            case 308:
                response = "Permanent Redirect";
                break;
            //4×× Client Error
            case 400:
                response = "Bad Request. Server could not understand the request due to invalid syntax.";
                break;
            case 401:
                response = "Unauthorized. The client must authenticate itself to get the requested response.";
                break;
            case 402:
                response = "Payment Required. Initial aim for creating this code was using it for digital payment systems however this is not used currently.";
                break;
            case 403:
                response ="Forbidden. The client does not have access rights to the content, i.e. they are unauthorized, so server is rejecting to give proper response.";
                break;
            case 404:
                response = "Not Found. The server can not find requested resource. The URL is not recognized or the endpoint is valid but the resource itself does not exist.";
                break;
            case 405:
                response = "Method Not Allowed. The request method is known by the server but has been disabled and cannot be used";
                break;
            case 406:
                response = "Not Acceptable. This response is sent when the web server, after performing server-driven content negotiation, doesn't find any content following the criteria given by the user agent.";
                break;
            case 407:
                response = "Proxy Authentication Required.";
                break;
            case 408:
                response = "Request Timeout";
                break;
            case 413:
                response = "Payload Too Large";
                break;
            case 414:
                response ="Request-URI Too Long";
                break;
            case 429:
                response = "Too Many Requests. The user has sent too many requests in a given amount of time (\"rate limiting\").";
                break;
            case 431:
                response="Request Header Fields Too Large. The server is unwilling to process the request because its header fields are too large";
                break;
            case 444:
                response = "Connection Closed Without Response";
                break;
            case 451:
                response="Unavailable For Legal Reasons. The user requests an illegal resource, such as a web page censored by a government.";
                break;
            case 499:
                response = "Client Closed Request";
                break;
            //5×× Server Error
            case 500:
                response= "Internal Server Error. The server has encountered a situation it doesn't know how to handle.";
                break;
            case 511:
                response = "Network Authentication Required. The client needs to authenticate to gain network access.";
                break;
            case 520:
                response ="Web server is returning an unknown error";
                break;
            case 522:
                response ="Connection timed out";
                break;

        }
        return response;
    }

}
