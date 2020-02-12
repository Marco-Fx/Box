package marco.zlc.dabl.common.support.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;

import javax.jms.ConnectionFactory;

/**
 *@描述
 *@创建人 zlc
 *@创建时间 2020/2/12 9:37
 *@修改人和其它信息 监听容器
 */
@Configuration
public class ActiveMqConfig {
    // queue模式的ListenerContainer
    @Bean
    public JmsListenerContainerFactory<?>jmsListenerContainerQueue(@Qualifier("pooledJmsConnectionFactory") ConnectionFactory activeMQConnectionFactory) {
        DefaultJmsListenerContainerFactory bean = new DefaultJmsListenerContainerFactory();
        bean.setConnectionFactory(activeMQConnectionFactory);
        return bean;
    }
    // topic模式的ListenerContainer
    @Bean
    public JmsListenerContainerFactory<?> jmsListenerContainerTopic(@Qualifier("pooledJmsConnectionFactory") ConnectionFactory activeMQConnectionFactory) {
        DefaultJmsListenerContainerFactory bean = new DefaultJmsListenerContainerFactory();
        //这里必须设置为true，false则表示是queue类型
        bean.setPubSubDomain(true);
        bean.setConnectionFactory(activeMQConnectionFactory);
        return bean;
    }
}
