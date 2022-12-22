package sania.rasheed;

import sania.rasheed.Models.APIResponse;

public interface OnFetchDataListener  {
    void onFetchData(APIResponse apiResponse, String message);
    void onError(String message);
}
