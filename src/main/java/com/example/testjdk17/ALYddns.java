// This file is auto-generated, don't edit it. Thanks.
package com.example.testjdk17;

import com.aliyun.alidns20150109.Client;
import com.aliyun.alidns20150109.models.UpdateDomainRecordRequest;
import com.aliyun.teaopenapi.models.Config;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

public class ALYddns {

    /**
     * @param accessKeyId
     * @param accessKeySecret
     * @return Client
     * @throws Exception
     */
    public static Client createClient(String accessKeyId, String accessKeySecret) throws Exception {
        Config config = new Config()
                .setAccessKeyId(accessKeyId)
                .setAccessKeySecret(accessKeySecret);
        config.endpoint = "alidns.cn-chengdu.aliyuncs.com";
        return new Client(config);
    }

    public static void main(String[] args) throws Exception {
        String recordId = args[0];
        String RR = args[1];
        String keyId = args[2];
        String keySecret = args[3];


        String innetIp = getInnetIp();
        System.out.println(innetIp);
        Client client = ALYddns.createClient(keyId, keySecret);
        UpdateDomainRecordRequest updateDomainRecordRequest = new UpdateDomainRecordRequest()
                .setRecordId(recordId)
                .setLang("java")
                .setRR(RR)
                .setType("A")
                .setValue(innetIp);
        client.updateDomainRecord(updateDomainRecordRequest);
        System.out.println("SUCCESS");
    }

    public static String getInnetIp() throws SocketException {
        String localip = null;
        String netip = null;
        Enumeration<NetworkInterface> netInterfaces;
        netInterfaces = NetworkInterface.getNetworkInterfaces();
        InetAddress ip = null;
        boolean finded = false;
        while (netInterfaces.hasMoreElements() && !finded) {
            NetworkInterface ni = netInterfaces.nextElement();
            Enumeration<InetAddress> address = ni.getInetAddresses();
            while (address.hasMoreElements()) {
                ip = address.nextElement();
                if (!ip.isSiteLocalAddress()
                    && !ip.isLoopbackAddress()
                    && ip.getHostAddress().indexOf(":") == -1) {
                    netip = ip.getHostAddress();
                    finded = true;
                    break;
                } else if (ip.isSiteLocalAddress()
                           && !ip.isLoopbackAddress()
                           && ip.getHostAddress().indexOf(":") == -1) {
                    localip = ip.getHostAddress();
                }
            }
        }
        if (netip != null && !"".equals(netip)) {
            return netip;
        } else {
            return localip;
        }
    }
}