package com.maximum.koreaartschool._sb0408.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberListService {

    @Autowired
    private MemberDao memberDao;

    public List<Member> getMemberList() {
        return memberDao.selectAll();
    }
}
