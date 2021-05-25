package com.example.demo.Service;

import de.test.consum.whiteTest.ExamRequest;
import de.test.consum.whiteTest.ExamResponse;
import de.test.consum.whiteTest.StudentRequest;
import de.test.consum.whiteTest.WhiteTestResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.stereotype.Service;
import org.springframework.ws.client.core.WebServiceTemplate;

@Service
public class WhiteTestService {

    private WebServiceTemplate serviceTemplate;

    @Autowired
    private Jaxb2Marshaller marshaller;


    public WhiteTestResponse getWhiteTestResponse(StudentRequest request){
        serviceTemplate = new WebServiceTemplate(marshaller);
        WhiteTestResponse response = (WhiteTestResponse) serviceTemplate.marshalSendAndReceive("http://localhost:8081/ws",request);
        return response;
    }

    public ExamResponse getExamList(ExamRequest request){
        serviceTemplate = new WebServiceTemplate(marshaller);
        ExamResponse examResponse = (ExamResponse) serviceTemplate.marshalSendAndReceive("http://localhost:8081/ws",request);
        return examResponse;
    }
}
