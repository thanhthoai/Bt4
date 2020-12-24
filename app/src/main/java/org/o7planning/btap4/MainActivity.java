package org.o7planning.btap4;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;
import android.widget.ViewFlipper;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

import category.Category;
import category.CategoryAdapter;
import shop.Shop;

public class MainActivity extends AppCompatActivity {
    RecyclerView rcvCategory;
    private CategoryAdapter categoryAdapter;
    Context context;
    ViewFlipper v_flipper;
    private TabLayout mTabLayout;
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = this;
        setContentView(R.layout.activity_main);
        rcvCategory= findViewById(R.id.rcv_category);
        categoryAdapter= new CategoryAdapter(this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,RecyclerView.VERTICAL,false);
        rcvCategory.setLayoutManager(linearLayoutManager);
        categoryAdapter.setData(getListCategory());
        rcvCategory.setAdapter(categoryAdapter);
        mTabLayout =findViewById(R.id.tab_layout);
        mViewPager = findViewById(R.id.view_pager);


        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager(), FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        mViewPager.setAdapter(viewPagerAdapter);

        mTabLayout.setupWithViewPager(mViewPager);


        //fileper chuyeern trang
        rcvCategory.setAdapter(categoryAdapter);
        int images [] = {R.drawable.a17,R.drawable.a18,R.drawable.a19,R.drawable.a16,R.drawable.a17,R.drawable.a16};
        v_flipper = findViewById(R.id.v_flipper);
        for (int image: images){
            flipperImages(image);
        }
    }

    private void flipperImages(int image) {
        ImageView imageView =  new ImageView(this);
        imageView.setBackgroundResource(image);
        v_flipper.addView(imageView);
        v_flipper.setFlipInterval(4000);
        v_flipper.setAutoStart(true);
        v_flipper.setInAnimation(this,android.R.anim.slide_in_left);
        v_flipper.setOutAnimation(this,android.R.anim.slide_out_right);
    }


    private List<Category> getListCategory(){
        List<Category> listCategory = new ArrayList<>();
        List<Shop>  listShop = new ArrayList<>();
        List<Shop>  listShop1 = new ArrayList<>();
        listShop.add(new Shop(R.drawable.r1,"Cuối năm xả hàng"));
        listShop.add(new Shop(R.drawable.r2,"Deal sôc từ 1k"));
        listShop.add(new Shop(R.drawable.r3,"Mã giảm giá hot"));
        listShop.add(new Shop(R.drawable.r4,"Xả hàng tồn chỉ từ 9k"));
        listShop.add(new Shop(R.drawable.r5,"Khung giờ săn sale"));
        listShop.add(new Shop(R.drawable.r6,"chỉ từ 1k thôi"));
        listShop.add(new Shop(R.drawable.r7,"Free ship extra"));
        listShop.add(new Shop(R.drawable.r10,"khung giờ săn sale"));
        listShop.add(new Shop(R.drawable.r11,"chỉ từ 1k"));
        listShop.add(new Shop(R.drawable.r12,"Free ship extra"));

        listShop1.add(new Shop(R.drawable.r6,"Thanh toán hóa đơn"));
        listShop1.add(new Shop(R.drawable.r7,"Nạp điện thoại"));
        listShop1.add(new Shop(R.drawable.r10,"Thanh toán tiện ích"));
        listShop1.add(new Shop(R.drawable.r12,"Vé xe rẻ nhất 10$"));
        listShop1.add(new Shop(R.drawable.r13,"Free ship extra"));
        listShop1.add(new Shop(R.drawable.r14,"khung giờ săn sale"));
        listShop1.add(new Shop(R.drawable.r15,"Hàng quốc tế"));
        listShop1.add(new Shop(R.drawable.r16,"Free ship extra"));
        listShop1.add(new Shop(R.drawable.r17,"khung giờ săn sale"));
        listShop1.add(new Shop(R.drawable.r15,"Hàng quốc tế"));



        listCategory.add(new Category("", listShop));
        listCategory.add(new Category("", listShop1));

        return listCategory;
    }
}
