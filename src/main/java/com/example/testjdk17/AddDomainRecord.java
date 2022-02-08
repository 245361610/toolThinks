//package com.example.testjdk17;
//
//import com.aliyun.alidns20150109.models.AddDomainRecordRequest;
//import com.aliyun.alidns20150109.models.AddDomainRecordResponse;
//import com.aliyuncs.DefaultAcsClient;
//import com.aliyuncs.IAcsClient;
//import com.aliyuncs.exceptions.ClientException;
//import com.aliyuncs.exceptions.ServerException;
//import com.aliyuncs.profile.DefaultProfile;
//import com.google.gson.Gson;
//public class AddDomainRecord {
//    public static void main(String[] args) {
//        DefaultProfile profile = DefaultProfile.getProfile("cn-hangzhou", "<accessKeyId>", "<accessSecret>");
//        IAcsClient client = new DefaultAcsClient(profile);
//        AddDomainRecordRequest request = new AddDomainRecordRequest();
//        request.setValue("3.0.3.0");
//        request.setType("A");
//        request.setRR("apitest");
//        request.setDomainName("dns-example.com");
//        try {
//            AddDomainRecordResponse response = client.getAcsResponse(request);
//            System.out.println(new Gson().toJson(response));
//        } catch (ServerException e) {
//            e.printStackTrace();
//        } catch (ClientException e) {
//            System.out.println("ErrCode:" + e.getErrCode());
//            System.out.println("ErrMsg:" + e.getErrMsg());
//            System.out.println("RequestId:" + e.getRequestId());
//        }
//    }
//}