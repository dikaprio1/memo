package com.example.service;

import com.example.dto.MemoRequestDto;
import com.example.dto.MemoResponseDto;

public interface MemoService {

    MemoResponseDto saveMemo(MemoRequestDto requestDto);
}
