package com.arunsoorya.myresearch.mvp;

/**
 * Created by T10778 on 19/06/2016.
 */
public class MainModel implements MainMVP.ModelOps {

    // Presenter reference
    private MainMVP.RequiredPresenterOps mPresenter;

    public MainModel(MainMVP.RequiredPresenterOps mPresenter) {
        this.mPresenter = mPresenter;
    }

    @Override
    public void insertNote(Note note) {
        mPresenter.onNoteInsert(note);
    }

    @Override
    public void removeNote(Note note) {
        mPresenter.onNoteRemoved(note);
    }

    @Override
    public void onDestroy() {

    }
}
