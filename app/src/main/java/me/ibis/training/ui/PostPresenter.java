package me.ibis.training.ui;

import java.util.List;

import me.ibis.training.model.Post;
import me.ibis.training.network.ApiClient;
import me.ibis.training.network.ApiInterface;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PostPresenter implements PostContract.Presenter{

    private PostContract.View view;

    public PostPresenter(PostContract.View view) {
        this.view = view;
    }

    @Override
    public void getPosts() {
        ApiInterface api = ApiClient.getApi();
        Call<List<Post>> call = api.getListPost();
        call.enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
                List<Post> posts = response.body();
                view.hideProgressBar();
                view.updateView(posts);
            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {

            }
        });
    }
}
