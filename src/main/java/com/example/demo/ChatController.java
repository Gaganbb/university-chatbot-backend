package com.example.demo;

import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin(origins = "*")
public class ChatController {

    private static final Map<String, String> knowledgeBase = new HashMap<>();

    public ChatController() {
        initializeKnowledgeBase();
    }

    @PostMapping("/api/chat")
    public Map<String, String> chat(@RequestBody Map<String, String> payload) {
        String userMessage = payload.get("message");
        if (userMessage == null) userMessage = "";

        String reply = getBotResponse(userMessage.toLowerCase());

        Map<String, String> response = new HashMap<>();
        response.put("reply", reply);
        return response;
    }

    private void initializeKnowledgeBase() {
        // Data is dynamically handled in getBotResponse for this advanced version
    }

    private String getBotResponse(String input) {

        // --- 1. 🎓 ADMISSIONS LOGIC ---
        if (input.contains("admission") || input.contains("apply")) {
            return "<h3>🎓 Admissions 2025-26</h3>" +
                    "<b>1. Process:</b><br>" +
                    "• Engineering: Based on KCET, COMEDK, or University Entrance Exam.<br>" +
                    "• Architecture: NATA Score mandatory.<br>" +
                    "• MBA/MCA: PGCET or KMAT ranking.<br><br>" +
                    "<b>2. Eligibility:</b><br>" +
                    "• UG: 10+2 with min 45% (40% for SC/ST).<br>" +
                    "• PG: Bachelor's degree with relevant stream.<br><br>" +
                    "<b>3. Documents Required:</b><br>" +
                    "• 10th & 12th Marks Cards, TC, Migration Cert, Caste Cert (if applicable).<br><br>" +
                    "<i>Tip: Visit suk.edu.in for the application link.</i>";
        }

        // --- 2. 📚 COURSES LOGIC ---
        if (input.contains("course") || input.contains("program") || input.contains("degree")) {
            return "<h3>📚 Academic Programs</h3>" +
                    "<b>Undergraduate (UG):</b><br>" +
                    "• <b>B.Tech:</b> CSE, AI&DS, Civil, E&E, E&C, Mechanical<br>" +
                    "• <b>B.Arch:</b> Architecture (5 Years)<br>" +
                    "• <b>B.Pharm / D.Pharm:</b> Pharmacy<br>" +
                    "• <b>BCA / BBM / B.Sc</b><br><br>" +
                    "<b>Postgraduate (PG):</b><br>" +
                    "• M.Tech, MBA, MCA, M.Sc, M.A., M.Com<br><br>" +
                    "<b>Doctoral:</b><br>" +
                    "• Ph.D. in Engineering, Science, & Management.";
        }

        // --- 3. 💰 FEES LOGIC ---
        if (input.contains("fee") || input.contains("cost") || input.contains("price")) {
            return "<h3>💰 Fee Structure & Financials</h3>" +
                    "<b>1. Estimated Fees (Per Year):</b><br>" +
                    "• B.Tech: ₹90,000 - ₹1,50,000 (varies by quota)<br>" +
                    "• MBA/MCA: ₹70,000 - ₹1,00,000<br>" +
                    "• B.Arch: As per COA/KEA norms<br>" +
                    "<i>*Note: Fees are subject to change. Please confirm with the office.</i><br><br>" +
                    "<b>2. Payment Modes:</b><br>" +
                    "• Demand Draft (DD), Online Bank Transfer, or UPI at the counter.<br><br>" +
                    "<b>3. Scholarships:</b><br>" +
                    "• SSP (Govt), Merit-based concessions available.";
        }

        // --- 4. 📞 CONTACT LOGIC ---
        if (input.contains("contact") || input.contains("phone") || input.contains("email") || input.contains("address")) {
            return "<h3>📞 Contact Us</h3>" +
                    "<b>📍 Campus Address:</b><br>" +
                    "Vidya Nagar, Kalaburagi – 585103, Karnataka.<br><br>" +
                    "<b>☎️ Phone:</b><br>" +
                    "08472-277854 / 9243219188<br><br>" +
                    "<b>📧 Email:</b><br>" +
                    "info@suk.edu.in<br><br>" +
                    "<b>🕒 Office Hours:</b><br>" +
                    "Tuesday - Sunday (10:00 AM - 5:00 PM)<br>" +
                    "<i>(Monday is a Holiday)</i>";
        }

        // --- GREETING / DEFAULT ---
        if (input.contains("hello") || input.contains("hi")) {
            return "Hello! I am the Sharnbasva University Assistant.<br>" +
                    "Please select an option below to get started.";
        }

        return "I can help with Admissions, Courses, Fees, and Contact info. Please select a button below or type your query.";
    }
}
