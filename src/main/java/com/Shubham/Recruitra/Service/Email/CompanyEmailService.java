package com.Shubham.Recruitra.Service.Email;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class CompanyEmailService {

    @Autowired
    private JavaMailSender mailSender;

    public void sendWelcomeEmailToCompany(String to, String companyName) throws MessagingException {
        String subject = "Welcome to Our Platform, " + companyName;
        String html = buildWelcomeCompanyEmail(companyName);
        sendHtmlEmail(to, subject, html);
    }

    public void sendWelcomeEmailToApplicant(String to, String applicantName) throws MessagingException {
        String subject = "Welcome to Our Platform, " + applicantName;
        String html = buildWelcomeApplicantEmail(applicantName);
        sendHtmlEmail(to, subject, html);
    }

    private void sendHtmlEmail(String to, String subject, String htmlContent) throws MessagingException {
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);
        helper.setTo(to);
        helper.setSubject(subject);
        helper.setText(htmlContent, true);
        mailSender.send(message);
    }


    private String buildWelcomeCompanyEmail(String companyName) {
        return """
                <html>
                    <body style="font-family: Arial, sans-serif;">
                        <h2 style="color: #2E86C1;">Welcome, %s! 🎉</h2>
                        <p>Thank you for registering your company on our platform.</p>
                        <p>You can now post job listings, view applicants, and manage your hiring process easily.</p>
                        <br>
                        <p>If you have any questions, feel free to contact our support team.</p>
                        <br>
                        <p>– The Recruitra Team</p>
                    </body>
                </html>
                """.formatted(companyName);
    }

    private String buildWelcomeApplicantEmail(String applicantName) {
        return """
                <html>
                    <body style="font-family: Arial, sans-serif;">
                        <h2 style="color: #28B463;">Welcome, %s! 🙌</h2>
                        <p>Thanks for joining our platform.</p>
                        <p>You can now explore job openings, apply to companies, and manage your applications.</p>
                        <br>
                        <p>We wish you all the best in your job search!</p>
                        <br>
                        <p>– The Recruitra Team</p>
                    </body>
                </html>
                """.formatted(applicantName);
    }
}