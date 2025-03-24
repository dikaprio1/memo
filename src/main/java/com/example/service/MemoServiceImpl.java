package com.example.service;

import com.example.dto.MemoRequestDto;
import com.example.dto.MemoResponseDto;
import com.example.entity.Memo;
import com.example.repository.MemoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class MemoServiceImpl implements MemoService {

    private final MemoRepository memoRepository;

    public MemoServiceImpl(MemoRepository memoRepository){
        this.memoRepository = memoRepository;
    }

    @Override
    public MemoResponseDto saveMemo(MemoRequestDto requestDto){
        Memo memo = new Memo(requestDto.getTitle(),requestDto.getContents());

        return new MemoResponseDto(memo);
    }

    @Override
    public List<MemoResponseDto> findAllMemos(){
        List<MemoResponseDto> allMemos = memoRepository.findAllMemos();

        return allMemos;
    }
    @Override
    public MemoResponseDto findMemoById(Long id){
        Memo memo = memoRepository.findMemoById(id);

        if(memo == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"id가 존재하지않음 "+id);
        }

        return new MemoResponseDto(memo);
    }
}
