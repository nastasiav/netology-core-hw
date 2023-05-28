package hw1.work2;

public class Worker {
    private OnTaskDoneListener callback;
    private OnTaskErrorListener callbackErrorListener;
    public Worker(OnTaskDoneListener callback, OnTaskErrorListener errorListener) {
        this.callback = callback;
        this.callbackErrorListener = errorListener;
    }

    public void start() {
        for (int i = 0; i < 100; i++) {
            if (i == 33)
                callbackErrorListener.onTaskError("Task " + i + " is not completed");
            else
                callback.onDone("Task " + i + " is done");
        }
    }

}
