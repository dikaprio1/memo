package com.example.controller;

import com.example.dto.MemoRequestDto;
import com.example.dto.MemoResponseDto;
import com.example.entity.Memo;
import com.example.service.MemoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/memos") // prefix
public class MemoController {

    private final MemoService memoService;

    public MemoController(MemoService memoService){
        this.memoService = memoService;
    }
    // 자료구조가 DB 역할 수행
    private final Map<Long, Memo> memoList = new HashMap<>();

    @PostMapping // 요청
    public ResponseEntity<MemoResponseDto> createMemo(@RequestBody MemoRequestDto requestDto) {
        // ServiceLayer 호출 및 응답
        return new ResponseEntity<>(memoService.saveMemo(requestDto), HttpStatus.CREATED);
    }

    @GetMapping
    public List<MemoResponseDto> findMemoById(){
        return memoService.findAllMemos();
    }
    @GetMapping("/{id}")
    public ResponseEntity<MemoResponseDto> findMemoById(@PathVariable Long id){

        return new ResponseEntity<>(memoService.findMemoById(id), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MemoResponseDto> updateMemoById(@PathVariable Long id,@RequestBody MemoRequestDto requestDto){

        Memo memo = memoList.get(id);

        if(memo == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        if(requestDto.getTitle() == null || requestDto.getContents() == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        memo.update(requestDto);

        return new ResponseEntity<>(new MemoResponseDto(memo), HttpStatus.OK);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<MemoResponseDto> updateTitle(@PathVariable Long id,@RequestBody MemoRequestDto requestDto){

        Memo memo = memoList.get(id);

        if(memo == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        if(requestDto.getTitle() == null || requestDto.getContents() != null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        memo.updateTitle(requestDto);

        return new ResponseEntity<>(new MemoResponseDto(memo), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMemoById(@PathVariable Long id){
        if(memoList.containsKey(id)){
            memoList.remove(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
