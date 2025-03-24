package com.example.repository;

import com.example.dto.MemoResponseDto;
import com.example.entity.Memo;

import java.util.List;

public interface MemoRepository {

    MemoResponseDto saveMemo(Memo memo);
    List<MemoResponseDto> findAllMemos();
    Memo findMemoById(Long id);
}
