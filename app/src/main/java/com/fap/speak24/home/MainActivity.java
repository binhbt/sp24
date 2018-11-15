package com.fap.speak24.home;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;

import com.fap.speak24.BaseActivity;
import com.fap.speak24.R;
import com.fap.speak24.model.User;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.vn.fa.adapter.FaAdapter;
import com.vn.fa.adapter.infinite.InfiniteAdapter;
import com.vn.fa.adapter.multipleviewtype.IViewBinder;
import com.vn.fa.widget.FaRecyclerView;

import java.util.List;

import butterknife.BindView;

public class MainActivity extends BaseActivity implements MainView {
    @BindView(R.id.list)
    FaRecyclerView recyclerView;
    private DatabaseReference mDatabase;
    private FaAdapter mAdapter;
    private MainPresenter mainPresenter = new MainPresenter();
    @Override
    protected void initView(Bundle bundle) {
        mainPresenter.attachView(this);
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        mDatabase = database.getReference("User");
        test();
        loadData();
        recyclerView.setRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {

            }
        });
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    private void loadData(){


    }
    private void test() {
        // Write a message to the database

        String userId = mDatabase.push().getKey();

        User user = new User();
        user.setEmail("binhbt1@abc.com");
        // String data = new Gson().toJson(user);

        mDatabase.child(userId).setValue(user);
    }

    private void onDataChanged() {
        mDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                User user = dataSnapshot.getValue(User.class);

                //Log.d(TAG, "User name: " + user.getName() + ", email " + user.getEmail());
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                //Log.w(TAG, "Failed to read value.", error.toException());
            }
        });
    }

    private void update(String userId) {
        String newEmail = "androidhive@gmail.com";

        mDatabase.child(userId).child("email").setValue(newEmail);
    }

    private void getList() {
        // My top posts by number of stars
        //String myUserId = getUid();
        Query myTopPostsQuery = mDatabase.child("User").child("user_status").equalTo("ONLINE");
        myTopPostsQuery.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
            // TODO: implement the ChildEventListener methods as documented above
            // ...
        });
    }

    @Override
    public void loadUserToview(List<User> userList) {
        if (mAdapter == null) {
            mAdapter = new FaAdapter();
            recyclerView.setAdapter(mAdapter);
            mAdapter.setOnLoadMoreListener(new InfiniteAdapter.OnLoadMoreListener() {
                @Override
                public void onLoadMore() {

                }
            });
        }
        mAdapter.clear();
        List<IViewBinder> viewBinders = (List<IViewBinder>) (List) userList;
        mAdapter.addAllDataObject(viewBinders);


    }
}
