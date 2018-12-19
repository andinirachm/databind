package id.alo.sampledatabinding.model;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.ObservableField;

import id.alo.sampledatabinding.BR;

/**
 * Created by Andini Rachmah on 04/12/18.
 */
public class Book extends BaseObservable {
    public ObservableField<String> bookId;
    public ObservableField<String> bookTitle;

    @Bindable
    public ObservableField<String> getBookId() {
        return bookId;
    }

    public void setBookId(ObservableField<String> bookId) {
        this.bookId = bookId;
        notifyPropertyChanged(BR.bookId);
    }

    @Bindable
    public ObservableField<String> getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(ObservableField<String> bookTitle) {
        this.bookTitle = bookTitle;
        notifyPropertyChanged(BR.bookTitle);
    }
}
