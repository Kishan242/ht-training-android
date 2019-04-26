package me.ibis.training.ui;

import java.util.List;

import me.ibis.training.model.Post;

public interface PostContract {

    interface View {

        void updateView(List<Post> posts);

        void hideProgressBar();

    }

    interface Presenter {

        void getPosts();

    }

    interface Actions {

        void onPostClicked(Post post);

    }

}
