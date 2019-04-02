package com.codegym.cms.controller;


import com.codegym.cms.model.Blog;
import com.codegym.cms.model.Category;
import com.codegym.cms.service.BlogService;
import com.codegym.cms.service.CategoryService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @Autowired
    private BlogService blogService;

    //-------------------Retrieve All Categories--------------------------------------------------------

    @RequestMapping(value = "/categories/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Category>> listAllCategory(){
        List<Category> categories = categoryService.findAll();
        if(categories.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(categories,HttpStatus.OK);
    }

    //-------------------Retrieve All Blogs By Category--------------------------------------------------------

    @RequestMapping(value = "/blogsByCategory/{id}", method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Blog>> listAllBogsByCategory(@PathVariable("id") int id){
        System.out.println("retrieve category's information with category's id:"+id);
        Category category = categoryService.findById(id);
        List<Blog> blogs = blogService.findAllByCategory(category);
        if(blogs == null){
            System.out.println("Blogs with category's id: "+id+" not found");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(blogs, HttpStatus.OK);
    }

    //-------------------Retrieve Blog By ID--------------------------------------------------------

    @RequestMapping(value = "/blog/{id}", method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Blog> getBlog(@PathVariable("id") int id){
        System.out.println("Read blog content with blog's id: "+ id);
        Blog blog = blogService.findById(id);
        if(blog == null){
            System.out.println("Blog with id: " + id + " not found");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(blog,HttpStatus.OK);
    }
}
