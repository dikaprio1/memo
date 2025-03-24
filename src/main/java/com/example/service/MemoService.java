package com.example.service;

import com.example.dto.MemoRequestDto;
import com.example.dto.MemoResponseDto;

import java.util.List;

public interface MemoService {

    MemoResponseDto saveMemo(MemoRequestDto requestDto);
    List<MemoResponseDto> findAllMemos();
    MemoResponseDto findMemoById(Long id);
}
