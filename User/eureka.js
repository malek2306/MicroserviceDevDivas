const Eureka = require('eureka-js-client').Eureka;
const eurekaHost = (process.env.EUREKA_DEFAULTZONE || 'localhost');
const eurekaPort = (process.env.EUREKA_PORT || 8761);
const hostName = (process.env.HOSTNAME || 'localhost');
const ipAddr = '127.0.0.1';
const appPort = 3000;

const client = new Eureka({
  instance: {
    app: 'user',
    hostName: hostName,
    ipAddr: ipAddr,
    port: {
      '$': appPort,
      '@enabled': true,
    },
    vipAddress: 'user',
    dataCenterInfo: {
      '@class': 'com.netflix.appinfo.InstanceInfo$DefaultDataCenterInfo',
      name: 'MyOwn',
    },
    statusPageUrl: `http://${hostName}:${appPort}`,  // Rendre le lien cliquable
  },
  eureka: {
    host: eurekaHost,
    port: eurekaPort,
    servicePath: '/eureka/apps/',
  },
});

client.start();