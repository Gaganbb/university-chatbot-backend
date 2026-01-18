package com.example.demo;

import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin(origins = "*")
public class ChatController {

    public ChatController() {
        // Expert System Initialized
    }

    @PostMapping("/api/chat")
    public Map<String, String> chat(@RequestBody Map<String, String> payload) {
        String userMessage = payload.get("message");
        if (userMessage == null) userMessage = "";

        String reply = getExpertResponse(userMessage.toLowerCase());

        Map<String, String> response = new HashMap<>();
        response.put("reply", reply);
        return response;
    }

    private String getExpertResponse(String input) {

        // --- 1. 👨‍🏫 FACULTY SEARCH ENGINE (Priority) ---

        // NEW: CS&D Faculty (Computer Science & Design)
        if (input.matches(".*(faculty|professor|teacher|staff).*") && (input.matches(".*(csd|design|computer science and design).*"))) {
            return "<h3>👨‍🏫 Faculty: Computer Science & Design (CS&D)</h3>" +
                    "<b>1. Dr. Sachinkumar Veerashetty</b> (Chairman & Assoc. Prof)<br>" +
                    "• Ph.D. (Medical Image Processing, VTU), M.Tech, B.E.<br>" +
                    "• <i>Expertise: Computer Vision, Texture Analysis</i><br><br>" +
                    "<b>2. Prof. Soumya</b> (Asst. Prof)<br>" +
                    "• M.Tech (CSE), B.TECH.<br><br>"+
            "<b>3. Prof. Sharnbasappa V. H.</b> (Asst. Prof)<br>" +
                    "• M.Tech (CSE), B.E.<br><br>" +
                    "<b>4. Prof. Sharnbasappa Noola</b> (Asst. Prof)<br>" +
                    "• M.Tech (CSE), B.E.<br><br>" +
                    "<b>5. Prof. Shilpa</b> (Asst. Prof)<br>" +
                    "• M.Tech (CSE), B.E.<br><br>"
                    ;
        }

        // CSE / AI / ISE Faculty
        if (input.matches(".*(faculty|professor|teacher|staff).*") && (input.matches(".*(cse|computer|cs|ai|data).*"))) {
            return "<h3>👨‍🏫 Faculty: Computer Science (CSE/AI)</h3>" +
                    "<b>1. Dr. Shivakumar Jawalgi</b> (Dean & Prof)<br>• Ph.D. in CSE<br><br>" +
                    "<b>2. Dr. Srikant Patil</b> (Dean, BCA/MCA)<br>• Ph.D. in Computer Science<br><br>" +
                    "<b>3. Prof. Vani H.</b> (Asst. Prof)<br>• M.Tech (CSE)<br><br>" +
                    "<b>4. Prof. Shivaraj V.</b> (Asst. Prof)<br>• M.Tech (Digital Electronics)";
        }

        // ECE / EEE Faculty
        if (input.matches(".*(faculty|professor|teacher).*") && (input.matches(".*(ece|eee|electronics|electrical).*"))) {
            return "<h3>👨‍🏫 Faculty: Electronics (ECE/EEE)</h3>" +
                    "<b>1. Dr. Lakshmi Patil Maka</b> (Dean & Prof)<br>• Ph.D. (Image Processing, VTU), M.Tech<br><br>" +
                    "<b>2. Dr. V. D. Mytri</b> (Pro Vice-Chancellor)<br>• Ph.D., M.Tech (Electronics)<br><br>" +
                    "<b>3. Dr. M. Sasikala</b> (Professor, EEE)<br>• Ph.D. (Electrical Engg)<br><br>" +
                    "<b>4. Dr. Suvarna Nandyal</b> (Professor)<br>• Ph.D. (Image Processing)<br><br>" +
                    "<b>5. Prof. Sushma S.</b> (Asst. Prof)<br>• M.Tech (VLSI)";
        }

        // Civil Faculty
        if (input.matches(".*(faculty|professor|teacher).*") && (input.matches(".*(civil|construction).*"))) {
            return "<h3>👨‍🏫 Faculty: Civil Engineering</h3>" +
                    "<b>1. Dr. B. S. Patil</b> (Professor & Head)<br>• Ph.D. (Structural Engg)<br><br>" +
                    "<b>2. Prof. R. G. Dharwad</b> (Assoc. Prof)<br>• M.Tech (Construction Tech)<br><br>" +
                    "<b>3. Prof. Shilpa B.</b> (Asst. Prof)<br>• M.Tech (Geotechnical)";
        }

        // Mechanical Faculty
        if (input.matches(".*(faculty|professor|teacher).*") && (input.matches(".*(mech|mechanical).*"))) {
            return "<h3>👨‍🏫 Faculty: Mechanical Engineering</h3>" +
                    "<b>1. Dr. Sharan Shegedhar</b> (Chairman)<br>• Ph.D. (Thermal Power)<br><br>" +
                    "<b>2. Prof. Amaresh P.</b> (Asst. Prof)<br>• M.Tech (Machine Design)";
        }

        // MBA / Business Faculty
        if (input.matches(".*(faculty|professor|teacher).*") && (input.matches(".*(mba|bba|business|management).*"))) {
            return "<h3>👨‍🏫 Faculty: Business Studies (MBA)</h3>" +
                    "<b>1. Dr. B. S. Hugar</b> (Chairperson)<br>• Ph.D. (Management), MBA<br><br>" +
                    "<b>2. Dr. S. S. Honnalli</b> (Registrar-Eval)<br>• Ph.D., MBA (HR/Marketing)<br><br>" +
                    "<b>3. Prof. Sunita B.</b> (Asst. Prof)<br>• MBA (Finance)";
        }

        // General Faculty Query (If no dept specified)
        if (input.contains("faculty") || input.contains("professor") || input.contains("teacher") || input.contains("staff")) {
            return "<h3>👨‍🏫 University Faculty</h3>" +
                    "Please specify the department to see the list:<br>" +
                    "• <b>CS & Design (CS&D)</b><br>" +
                    "• <b>Computer Science (CSE)</b><br>" +
                    "• <b>Electronics (ECE/EEE)</b><br>" +
                    "• <b>Civil / Mech</b><br>" +
                    "• <b>MBA Faculty</b>";
        }


        // --- 2. 🕒 TIMINGS & SCHEDULE ---
        if (input.matches(".*(time|timing|hour|open|close|working|schedule|day|holiday|monday|sunday).*")) {
            return "<h3>🕒 University Schedule</h3>" +
                    "<b>✅ Working Days:</b> Tuesday to Sunday<br>" +
                    "<b>⌚ Office Hours:</b> 10:00 AM - 5:00 PM<br><br>" +
                    "<b>⚠️ Important:</b><br>" +
                    "• The University is <span style='color:red; font-weight:bold;'>CLOSED on MONDAYS</span>.<br>" +
                    "• Administrative offices and classes function on Sundays.";
        }

        // --- 3. 🏛️ LEADERSHIP ---
        if (input.matches(".*(vc|vice chancellor|registrar|dean|finance|head|leader|principal|who is).*")) {
            return "<h3>🏛️ Key Leadership</h3>" +
                    "<b>Chancellor:</b> Poojya Dr. Sharnbaswappa Appa<br>" +
                    "<b>Vice-Chancellor:</b> Dr. Anilkumar G. Bidve (Ph.D. Lasers)<br>" +
                    "<b>Registrar:</b> Dr. S. G. Dollegoudar (Ph.D. English)<br>" +
                    "<b>Registrar (Eval):</b> Dr. S. S. Honnalli<br>" +
                    "<b>Dean (Engg Women):</b> Dr. Lakshmi Patil Maka<br>" +
                    "<b>Dean (Engg Co-Ed):</b> Dr. Shivakumar Jawalgi";
        }

        // --- 4. 💰 FEES ---
        if (input.contains("fee") || input.contains("cost")) {
            if (input.contains("hostel")) {
                return "<h3>🛏️ Hostel Fees</h3>Approx ₹40k - ₹60k/year (Includes Mess).";
            }
            return "<h3>💰 Estimated Fees (Per Year)</h3>" +
                    "• B.Tech: ₹90,000 - ₹1.5L<br>" +
                    "• MBA/MCA: ₹70,000 - ₹1.0L<br>" +
                    "• B.Arch: As per COA norms<br>" +
                    "<i>(Scholarships available for Merit/SC/ST)</i>";
        }

        // --- 5. 🎓 ADMISSIONS ---
        if (input.contains("admission") || input.contains("apply") || input.contains("entrance")) {
            return "<h3>🎓 Admissions 2025-26</h3>" +
                    "<b>1. Process:</b><br>" +
                    "• Engineering: Based on KCET, COMEDK, or University Entrance Exam.<br>" +
                    "• Architecture: NATA Score mandatory.<br>" +
                    "• MBA/MCA: PGCET or KMAT ranking.<br><br>" +
                    "<b>2. Eligibility:</b><br>" +
                    "• UG: 10+2 with min 45% (40% for SC/ST).<br>" +
                    "• PG: Bachelor's degree with relevant stream.<br>" +
                    "<i>Tip: Visit suk.edu.in for the application link.</i>";
        }

        // --- 6. 📚 COURSES ---
        if (input.matches(".*(course|program|branch).*")) {
            return "<h3>📚 Programs Offered</h3>" +
                    "• <b>Engg:</b> CS & Design, CSE, AI&DS, Civil, ECE, EEE, Mech<br>" +
                    "• <b>Medical:</b> B.Pharm, D.Pharm<br>" +
                    "• <b>Mgmt:</b> MBA, BBA, MCA, BCA<br>" +
                    "• <b>Arch:</b> B.Arch (5 Years)";
        }

        // --- 7. 🚀 PLACEMENTS ---
        if (input.matches(".*(placement|job|recruit|package).*")) {
            return "<h3>🚀 Placements</h3>" +
                    "• <b>Recruiters:</b> HCL, Deloitte, Accenture, Wipro.<br>" +
                    "• <b>Avg Package:</b> 3-4 LPA<br>" +
                    "• <b>Highest:</b> 10+ LPA";
        }

        // --- 8. 🏢 FACILITIES ---
        if (input.matches(".*(hostel|library|wifi|bus).*")) {
            return "<h3>🏢 Facilities</h3>" +
                    "• <b>Hostels:</b> Boys/Girls separate.<br>" +
                    "• <b>Library:</b> 24/7 Digital Library.<br>" +
                    "• <b>Transport:</b> City-wide Bus facility.";
        }

        // --- 9. 📞 CONTACT ---
        if (input.matches(".*(contact|address|phone|email).*")) {
            return "<h3>📞 Contact Us</h3>" +
                    "<b>📍 Address:</b> Vidya Nagar, Kalaburagi – 585103.<br>" +
                    "<b>☎️ Phone:</b> 08472-277854<br>" +
                    "<b>📧 Email:</b> info@suk.edu.in";
        }

        // --- 10. GREETING ---
        if (input.matches(".*(hello|hi|hey).*")) {
            return "Hello! I am the <b>University Expert Assistant</b>.<br>" +
                    "Ask me about <b>Faculty, Admissions, Fees,</b> or <b>Timings</b>.";
        }

        return "I can help with Faculty details, Admissions, Timings, and Fees. Please ask a specific question.";
    }
}
