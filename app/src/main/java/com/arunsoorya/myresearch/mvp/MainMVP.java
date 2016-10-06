package com.arunsoorya.myresearch.mvp;

/**
 * Created by T10778 on 19/06/2016.
 */
public interface MainMVP {
    /**
     * View mandatory methods. Available to Presenter
     *      Presenter -> View
     */
    interface RequiredViewOps {
        void showToast(String msg);
        void showAlert(String msg);
        // any other ops
    }

    /**
     * Operations offered from Presenter to View
     *      View -> Presenter
     */
    interface PresenterOps{
        void onConfigurationChanged(RequiredViewOps view);
        void onDestroy(boolean isChangingConfig);
        void newNote(String textNote);
        void deleteNote(Note note);
        // any other ops to be called from View
    }

    /**
     * Operations offered from Presenter to Model
     *      Model -> Presenter
     */
    interface RequiredPresenterOps {
        void onNoteInsert(Note novaNote);
        void onNoteRemoved(Note notaRemoved);
        void onError(String errorMsg);
        // Any other returning operation Model -> Presenter
    }

    /**
     * Model operations offered to Presenter
     *      Presenter -> Model
     */
    interface ModelOps {
        void insertNote(Note note);
        void removeNote(Note note);
        void onDestroy();
        // Any other data operation
    }
}
