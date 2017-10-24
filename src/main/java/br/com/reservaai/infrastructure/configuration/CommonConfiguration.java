package br.com.reservaai.infrastructure.configuration;

import br.com.reservaai.infrastructure.MessageHolder;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.filter.CharacterEncodingFilter;

import java.util.Locale;

/**
 * @author Arthur Gregorio
 *
 * @version 1.0.0
 * @since 1.0.0, 05/09/2017
 */
@Import({
        SecurityConfiguration.class
})
@Configuration
public class CommonConfiguration {

    /**
     * @return the bean validation instance
     */
    @Bean
    public Validator configureValidator() {
        return new LocalValidatorFactoryBean();
    }

    /**
     * Configure the environment to translate the i18n messages
     *
     * @return a message source for translating our messages
     */
    @Bean
    public MessageSource configureMessages() {

        Locale.setDefault(new Locale("pt", "BR"));

        final ReloadableResourceBundleMessageSource messageSource
                = new ReloadableResourceBundleMessageSource();

        messageSource.setCacheSeconds(0);
        messageSource.setDefaultEncoding("UTF-8");
        messageSource.setAlwaysUseMessageFormat(true);
        messageSource.setUseCodeAsDefaultMessage(true);

        messageSource.setBasenames(
                "classpath:i18n/messages",
                "classpath:i18n/constants",
                "classpath:i18n/exceptions"
        );

        // set this bundle on the messages value holder
        MessageHolder.setSource(messageSource);

        return messageSource;
    }

    /**
     * @return the encoding filter for this application
     */
    @Bean
    public CharacterEncodingFilter configureEncodingFilter() {

        final CharacterEncodingFilter filter = new CharacterEncodingFilter();

        filter.setEncoding("UTF-8");
        filter.setForceEncoding(true);

        return filter;
    }

    /**
     * @return the default password encoder for the security subsystem
     */
    @Bean
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder(13);
    }
}
