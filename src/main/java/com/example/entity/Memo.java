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

    public void update(MemoRequestDto RequestDto){
        this.title=RequestDto.getTitle();
        this.contents=RequestDto.getContents();
    }
    public void updateTitle(MemoRequestDto RequestDto){
        this.title=RequestDto.getTitle();
    }
}
