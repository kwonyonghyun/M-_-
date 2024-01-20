package com.example.springauthenticationwithmetamask.Service;

import com.example.springauthenticationwithmetamask.Entity.TockenCreatLog;
import com.example.springauthenticationwithmetamask.Form.TockenCreateForm;
import com.example.springauthenticationwithmetamask.Respository.TockenLogRepository;
import com.example.springauthenticationwithmetamask.Controller.SessionClass;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TockenService {

    private final TockenLogRepository tockenLogRepository;

    public TockenCreatLog createFormToCreateLog(TockenCreateForm createForm, HttpServletRequest request){
        HttpSession session=request.getSession();
        return TockenCreatLog.builder()
                .numOfTocken(createForm.getDuration()/60)
                .userId(SessionClass.getUsernameFromSession(session))
                .duration(createForm.getDuration())

                .build();

    }

    public TockenCreatLog save(TockenCreatLog tockenCreatLog){
        tockenLogRepository.save(tockenCreatLog);
        System.out.println(tockenCreatLog.toString());
        return tockenCreatLog;
    }

    public List<TockenCreatLog> getAll(){
        return tockenLogRepository.findAll();
    }
}
