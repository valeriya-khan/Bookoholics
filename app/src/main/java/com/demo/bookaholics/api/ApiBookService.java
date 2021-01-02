package com.demo.bookaholics.api;

import com.demo.bookaholics.pojo.BookResponse;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiBookService {
    static final String PARAMS_API_KEY = "key";
    static final String PARAMS_SEARCH_QUERY = "q";
    static final String PARAMS_LANGUAGE_RESTRICTION = "langRestrict";
    static final String PARAMS_ORDER_BY = "orderBy";
    static final String PARAMS_START_INDEX = "startIndex";

    @GET("volumes")
    Observable<BookResponse> getBooks(@Query(PARAMS_API_KEY) String api_key,
                                      @Query(PARAMS_SEARCH_QUERY) String search_query,
                                      @Query(PARAMS_LANGUAGE_RESTRICTION) String lang_restriction,
                                      @Query(PARAMS_ORDER_BY) String order_by,
                                      @Query(PARAMS_START_INDEX) int start_index);

}
