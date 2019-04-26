package me.ibis.training.network;

import java.util.List;
import java.util.concurrent.Callable;

import me.ibis.training.model.Post;
import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {

    @GET("posts")
    Call<List<Post>> getListPost();

}
