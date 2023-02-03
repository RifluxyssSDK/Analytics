package com.rifluxyss.app.analyticstracking.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.rifluxyss.app.analyticstracking.repository.UploadLogsRepository;

import java.io.IOException;


/**
 * This class is APi ViewModels
 */
public class UploadLogsViewModel extends ViewModel {

    /**
     * Initialization of mutableLiveData
     */
    private MutableLiveData<String> mutableLiveData;
    /**
     * Initialization of mUploadLogsRepository
     */
    private UploadLogsRepository mUploadLogsRepository;

    /**
     * Initialization of APi Repository of   UploadLogsRepository Object creation
     */
    public void init() {
        if (mutableLiveData != null) {
            return;
        }
        mUploadLogsRepository = new UploadLogsRepository().getInstance();
    }

    /**
     * @param logsPayLoad params of logsPayLoad string value of API uploadlogdata
     * @return Response of Data get in MutableLiveData
     * @throws IOException
     */
    public MutableLiveData<String> uploadLogs(String logsPayLoad) throws IOException {

        mutableLiveData = mUploadLogsRepository.uploadLogs(logsPayLoad);
        return mutableLiveData;

    }
}
