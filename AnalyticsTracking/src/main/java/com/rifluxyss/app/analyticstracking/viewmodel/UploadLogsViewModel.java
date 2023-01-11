package com.rifluxyss.app.analyticstracking.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.rifluxyss.app.analyticstracking.repository.UploadLogsRepository;

import java.io.IOException;


public class UploadLogsViewModel extends ViewModel {

    private MutableLiveData<String> mutableLiveData;
    private UploadLogsRepository mUploadLogsRepository;

    public void init(){
        if (mutableLiveData != null){
            return;
        }
        mUploadLogsRepository = new UploadLogsRepository().getInstance();
    }

    public MutableLiveData<String> uploadLogs(String logsPayLoad) throws IOException {

        mutableLiveData = mUploadLogsRepository.uploadLogs(logsPayLoad);
        return mutableLiveData;

    }
}
