package com.aksshop.shoppingapp.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;

import android.os.Bundle;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.aksshop.shoppingapp.adapters.CategoryAdapter;
import com.aksshop.shoppingapp.adapters.ProductAdapter;
import com.aksshop.shoppingapp.databinding.ActivityMainBinding;
import com.aksshop.shoppingapp.model.Category;
import com.aksshop.shoppingapp.model.Product;
import com.aksshop.shoppingapp.utils.Constants;

import org.imaginativeworld.whynotimagecarousel.model.CarouselItem;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    CategoryAdapter categoryAdapter;
    ArrayList<Category> categories;


    ProductAdapter productAdapter;
    ArrayList<Product> products;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        initCategories();
        initProducts();
        initSlider();
    }

    private void initSlider() {

        binding.carousel.addData(new CarouselItem("https://tse2.mm.bing.net/th?id=OIP.lsY37XeJjR9lt7thJrdNVgHaGE&pid=Api&P=0&h=180","Some caption here"));
        binding.carousel.addData(new CarouselItem("https://tse4.mm.bing.net/th?id=OIP.0ep4oPs1GRBHsMhkSb8a_wHaEc&pid=Api&P=0&h=180","Some caption here"));
        binding.carousel.addData(new CarouselItem("https://tse3.mm.bing.net/th?id=OIP.i26SAgaRCjxKYvhGBgTxJwHaDt&pid=Api&P=0&h=180","Some caption here"));
    }

    void initCategories(){

        categories = new ArrayList<>();
        categories.add(new Category("Sport",  "https://tutorials.mianasad.com/ecommerce/uploads/category/1686703071151.png", "#FFFFFFFF", "Some Description", 1));
        categories.add(new Category("Beauty and Personal Care",  "https://tutorials.mianasad.com/ecommerce/uploads/category/1686881567866.png", "#FFFFFFFF", "Some Description", 1));
        categories.add(new Category("Clothes",  "https://tutorials.mianasad.com/ecommerce/uploads/category/1686665304404.png", "#FFFFFFFF", "Some Description", 1));
        categories.add(new Category("Fast Food",  "https://tutorials.mianasad.com/ecommerce/uploads/category/1686702863294.png", "#FFFFFFFF", "Some Description", 1));
        categoryAdapter = new CategoryAdapter(this,categories);

        getCategories();

        GridLayoutManager layoutManager = new GridLayoutManager(this,4);
        binding.categoriesList.setLayoutManager(layoutManager);
        binding.categoriesList.setAdapter(categoryAdapter);
    }

    void getCategories(){
        RequestQueue queue = Volley.newRequestQueue(this);
        StringRequest request = new StringRequest(Request.Method.GET, Constants.GET_CATEGORIES_URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                try {
                    JSONObject mainObj = new JSONObject(response);
                    if (mainObj.getString("status").equals("success")){
                        JSONArray categoriesArray = mainObj.getJSONArray("categories");



                    } else {
                        // Do Nothing
                    }


                } catch (JSONException e){
                    e.printStackTrace();
                }


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        queue.add(request);
    }

    void initProducts(){

        products = new ArrayList<>();
        products.add(new Product("Jack & Jeans","https://tse4.mm.bing.net/th?id=OIP.0E2VvBOt1pzIy1PoXvE6cwHaLF&pid=Api&P=0&h=180","",12,12,1,1));
        products.add(new Product("Group Pic","https://tse4.mm.bing.net/th?id=OIP.0E2VvBOt1pzIy1PoXvE6cwHaLF&pid=Api&P=0&h=180","",12,12,1,1));
        products.add(new Product("PhotoSoot","https://tse3.mm.bing.net/th?id=OIP.4xUV5LnIkwKBfn_kkSUfqgHaJ4&pid=Api&P=0&h=180","",12,12,1,1));
        products.add(new Product("Formal","https://tse3.mm.bing.net/th?id=OIP.GrfWjWkECPU_eF5TfRtrAwHaNK&pid=Api&P=0&h=180","",12,12,1,1));
        products.add(new Product("T-Shirt Yellow","https://tse1.mm.bing.net/th?id=OIP.9hdsAG0nh-0-GdlD-kshKAHaLG&pid=Api&P=0&h=180","",12,12,1,1));
        products.add(new Product("Style","https://tse4.mm.bing.net/th?id=OIP.zl0KOxKn-BsWUWF69X62cgHaJE&pid=Api&P=0&h=180","",12,12,1,1));

        productAdapter = new ProductAdapter(this,products);


        GridLayoutManager layoutManager = new GridLayoutManager(this,2);
        binding.productList.setLayoutManager(layoutManager);
        binding.productList.setAdapter(productAdapter);
    }
}