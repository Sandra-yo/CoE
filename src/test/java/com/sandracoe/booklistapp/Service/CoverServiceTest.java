package com.sandracoe.booklistapp.Service;

import com.sandracoe.booklistapp.Objects.BookCover;
import com.sandracoe.booklistapp.Services.CoverService;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class CoverServiceTest {
    @Test
    @DisplayName("It should get the cover")
    public void getCover(){         
        BookCover cover = CoverService.getCover("8401322154"); 
        
        Assertions.assertThat(cover.getStatusCode()).isEqualTo(200);
        Assertions.assertThat(cover.getUrl()).isEqualTo("https://covers.openlibrary.org/b/isbn/8401322154-S.jpg");
    }


}
