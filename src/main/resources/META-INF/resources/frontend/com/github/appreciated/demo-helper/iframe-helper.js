function initIFrameObserver(element) {
    var iframeHistroy = element.contentWindow.history;
    var pushState = iframeHistroy.pushState;
    iframeHistroy.pushState = function (states) {
        if (typeof iframeHistroy.onpushstate == "function") {
            iframeHistroy.onpushstate({state: state});
        }
        var push = pushState.apply(iframeHistroy, arguments);
        element.$server.onUrlChanged(arguments[2]);
        return push;
    };
}

