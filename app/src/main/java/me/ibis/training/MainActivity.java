package me.ibis.training;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;


import java.util.ArrayList;
import java.util.List;

import me.ibis.training.model.Post;
import me.ibis.training.network.ApiClient;
import me.ibis.training.network.ApiInterface;
import me.ibis.training.ui.PostContract;
import me.ibis.training.ui.PostPresenter;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements PostContract.View, PostContract.Actions {

    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private RecyclerView.Adapter adapter;
    private List<Post> posts;
    private ProgressBar progressBar;
    private PostContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recycler_view);
        progressBar = findViewById(R.id.progress_bar);
        init();
        presenter = new PostPresenter(this);
        presenter.getPosts();

    }


    private void init() {
        posts = new ArrayList<>();
        layoutManager = new LinearLayoutManager(this);
        adapter = new PostAdapter(this, posts, this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void updateView(List<Post> posts) {
        this.posts.clear();
        this.posts.addAll(posts);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void hideProgressBar() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void onPostClicked(Post post) {
        Toast.makeText(this, post.getTitle(), Toast.LENGTH_SHORT).show();
    }
}
