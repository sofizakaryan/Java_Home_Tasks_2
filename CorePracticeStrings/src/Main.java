//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
void main() {
    String testForSearch = "When you first start to evaluate a cloud migration, the    decisions to be made, stakeholders who need to be involved, it can sometimes feel overwhelming – and with good reason. A move to the cloud can take time, resources, and manpower, and while companies are nearly universally glad they made those investments, that doesn't cancel out the fact that they take strategic planning and up-front work."
            + "What do you need to plan for? Who needs to be involved (and when)? What roles and responsibilities need to be divided up? The answers vary a bit depending on your company size, the scope of your migration, and whether you have the budget (or need) for a migration partner."
            + "Below are the typical roles and responsibilities we see from successful migrations – and some tips to prepare your team for success. Because without the right team in place, missed deadlines, duplicative work, and post-migration workflow issues become much greater risks.";

    //Starts with de
    String startsWith = "de";

    //(keep uppercases) | any char to space and then split
    Arrays.stream(testForSearch.replaceAll("[.()?,!]", " ").trim().split(" "))
            .forEach((s) -> {if (s.length() > 2 && s.substring(0, 2).equals(startsWith)) { System.out.println(s); }});
}
