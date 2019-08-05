package com.example.mvvm.model;

import android.databinding.BaseObservable;
import android.databinding.ObservableField;

public class TaskItem extends BaseObservable{
    public final ObservableField<String> state = new ObservableField<>();
    public final ObservableField<String> event = new ObservableField<>();
}
