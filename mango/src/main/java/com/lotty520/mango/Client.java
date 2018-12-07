package com.lotty520.mango;

import io.reactivex.disposables.Disposable;

/**
 * @author lotty
 */
public class Client {

    private Disposable mDisposable;


    public Client(Disposable disposable) {
        this.mDisposable = disposable;
    }

    void cancel() {
        mDisposable.dispose();
    }

    boolean iscanceled() {
        return mDisposable.isDisposed();
    }


}
