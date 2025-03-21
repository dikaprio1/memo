package com.example.service;

import com.example.dto.MemoRequestDto;
import com.example.dto.MemoResponseDto;
import com.example.entity.Memo;
import com.example.repository.MemoRepository;
import org.springframework.stereotype.Service;

@Service
public class MemoServiceImpl implements MemoService {

    private final MemoRepository memoRepository;

    public MemoServiceImpl(MemoRepository memoRepository){
        this.memoRepository = memoRepository;
    }

    @Override
    public MemoResponseDto saveMemo(MemoRequestDto requestDto){
        Memo memo = new Memo(requestDto.getTitle(),requestDto.getContents());

        Memo savedMemo = memoRepository.saveMemo(memo);

        return new MemoResponseDto(savedMemo);
    }
}
