package com.example.entity;

import com.example.dto.MemoRequestDto;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Memo {

    private Long id;
    private String title;
    private String contents;

    public Memo(String title,String contents){
        this.title =title;
        this.contents =contents;
    }

    public void update(MemoRequestDto RequestDto){
        this.title=RequestDto.getTitle();
        this.contents=RequestDto.getContents();
    }
    public void update(String title){
        this.title=title;
    }
}
