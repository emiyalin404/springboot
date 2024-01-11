package net.javaguides.service;

import org.springframework.stereotype.Service;

import net.javaguides.entity.Keyword;
import net.javaguides.repository.KeywordRepository;

import javax.servlet.http.HttpServletRequest;

@Service
public class KeywordServiceImpl implements KeywordService {

    private KeywordRepository keywordRepository;

    public KeywordServiceImpl(KeywordRepository keywordRepository) {
        this.keywordRepository = keywordRepository;
    }

    public Keyword createKeyword(Keyword keyword) {
        return keywordRepository.save(keyword);
    }

    public void setKeywordInSession(HttpServletRequest request) {
        Keyword keyword =getKeyword();

    }

    public Keyword getKeyword() {
        Keyword keyword=new Keyword();
        return keyword;
    }
}
