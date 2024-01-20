package com.example.springauthenticationwithmetamask.Entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;


@Getter
@Entity
@RequiredArgsConstructor
public class TockenCreatLog {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long numOfTocken;
    private String userId;
    private Long duration;

    @Builder
    public TockenCreatLog(Long numOfTocken,String userId,Long duration){
        this.numOfTocken=numOfTocken;
        this.userId=userId;
        this.duration=duration;
    }

    @Override
    public String toString() {
        return "TockenCreatLog{" +
                "numOfTocken=" + numOfTocken +
                ", userId='" + userId + '\'' +
                ", duration=" + duration +
                '}';
    }
}
