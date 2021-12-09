package com.sandracoe.booklistapp.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import com.sandracoe.booklistapp.Entities.Category;
import com.sandracoe.booklistapp.Objects.CategoryObj;
import com.sandracoe.booklistapp.Repositories.CategoryRepository;
import com.sandracoe.booklistapp.Services.CategoryService;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class CategoryServiceTest {
    @Spy
    private CategoryRepository RepositoryMock;

    
    @InjectMocks
    private CategoryService serviceMock = new CategoryService();

    @Captor
    private ArgumentCaptor<Category> categoryArgumentCaptor;
    
    private Category category1 = new Category(1, "Horror");
    private Category category2 = new Category(2, "Comedy");

    private CategoryObj c1 = new CategoryObj(category1);
    private CategoryObj c2 = new CategoryObj(category2);

    @Test
    @DisplayName("It should get all existing categories")
    public void getAllCategories(){         
        //create return response from repository
        List<Category> categories = Arrays.asList(category1,category2);
        
        //create return response from service
        List<CategoryObj> response = Arrays.asList(c1,c2);
        
        //adding action to return
        Mockito.when(RepositoryMock.findAll()).thenReturn(categories);
        
        //calling method         
        List<CategoryObj> categoryResponse = serviceMock.getAllCategories();  

        Assertions.assertThat(categoryResponse).isEqualTo(response);
        Assertions.assertThat(categoryResponse.get(0).getCategoryName()).isEqualTo("Horror");
    }

    //Add a new category successfully
    @Test
    @DisplayName("It should add a new category")
    public void addCategory(){                    
        serviceMock.addCategory(category1);                   
        Mockito.verify(RepositoryMock, Mockito.times(1)).save(categoryArgumentCaptor.capture());
        Assertions.assertThat(categoryArgumentCaptor.getValue().getCategoryName()).isEqualTo("Horror");
    }

    @Test
    @DisplayName("It should update an existing category")
    public void updateCategory(){
        category1.setCategoryName("Horror/Terror");
        serviceMock.updateCategory(category1);                   
        Mockito.verify(RepositoryMock, Mockito.times(1)).save(categoryArgumentCaptor.capture());
        Assertions.assertThat(categoryArgumentCaptor.getValue().getCategoryName()).isEqualTo("Horror/Terror");
        Assertions.assertThat(categoryArgumentCaptor.getValue()).isEqualTo(category1);
    }

    @Test
    @DisplayName("It should remove an existing category")
    public void removeUser(){
        Mockito.when(RepositoryMock.findById(category1.getId())).thenReturn(Optional.of(category1));
        serviceMock.removeCategory(1);  
        Mockito.verify(RepositoryMock, Mockito.times(1)).deleteById(1);
    }

    @Test
    @DisplayName("It shouldn't remove any user ")
    public void tryToRemoveAnUnexistingCategory(){
        Mockito.when(RepositoryMock.findById(5)).thenReturn(null);
        String response = serviceMock.removeCategory(5);  
        Assertions.assertThat(response).contains("error: ");
    }

}
