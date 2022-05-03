public class Worker {

    private OnTaskDoneListener callback;
    private OnTaskErrorListener errorCallback;

    public Worker(OnTaskDoneListener callback, OnTaskErrorListener errorCallback) {
        this.callback = callback;
        this.errorCallback = errorCallback;
    }

    @FunctionalInterface
    public interface OnTaskDoneListener {
        void onDone(String result);
    }

    public void start(){
        for(int i=0; i< 100; i++){
            if(i == 33){
                errorCallback.onError("Task " + i + " is not done due to unknown error");
            }
            callback.onDone("Task " + i + " is done");
        }
    }

    @FunctionalInterface
    public interface OnTaskErrorListener {
        void onError(String error);
    }
}
