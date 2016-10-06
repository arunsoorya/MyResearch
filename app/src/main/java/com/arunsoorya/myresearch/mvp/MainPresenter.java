package com.arunsoorya.myresearch.mvp;

import java.lang.ref.WeakReference;

/**
 * Created by T10778 on 19/06/2016.
 */
public class MainPresenter  implements MainMVP.RequiredPresenterOps, MainMVP.PresenterOps  {

    // Layer View reference
    private WeakReference<MainMVP.RequiredViewOps> mView;
    // Layer Model reference
    private MainMVP.ModelOps mModel;
    private boolean mIsChangingConfig;

    public MainPresenter(MainMVP.RequiredViewOps mView) {
        this.mView = new WeakReference<>(mView);
        this.mModel = new MainModel(this);
    }

    @Override
    public void onConfigurationChanged(MainMVP.RequiredViewOps view) {
        mView = new WeakReference<>(view);
    }

    @Override
    public void onDestroy(boolean isChangingConfig) {
        mView = null;
        mIsChangingConfig = isChangingConfig;
        if ( !isChangingConfig ) {
            mModel.onDestroy();
        }
    }

    @Override
    public void newNote(String textNote) {
        Note note = new Note();
        note.setText(textNote);
        note.setDate("today");
        mModel.insertNote(note);
    }

    @Override
    public void deleteNote(Note note) {
        mModel.removeNote(note);
    }

    @Override
    public void onNoteInsert(Note newNote) {
        mView.get().showToast("New register added at " + newNote.getDate());
    }

    @Override
    public void onNoteRemoved(Note notaRemovida) {
        mView.get().showToast("Note removed");
    }

    @Override
    public void onError(String errorMsg) {
        mView.get().showAlert(errorMsg);
    }
}
