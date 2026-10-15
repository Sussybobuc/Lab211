package controller;

import model.*;
import view.ConsoleForm;
import view.Menu;

import java.util.List;

public class ManageCandidate {
    CandidateList candidateList = new CandidateList();
    ConsoleForm consoleForm = new ConsoleForm();

    public void execute() {
        while (true) {
            int choice = Menu.getChoice();
            switch (choice) {
                case 1:
                    do {
                        Candidates basicInfo = consoleForm.createNewCandidates();
                        Experienced experienced = consoleForm.createNewExperienced();
                        Candidates createE = candidateList.createCandidate(1,
                                basicInfo.getFirstName(),
                                basicInfo.getLastName(),
                                basicInfo.getBirthdate(),
                                basicInfo.getAddress(),
                                basicInfo.getPhone(),
                                basicInfo.getEmail(),
                                experienced.getExplnYear(),
                                experienced.getProSkill(),
                                null, null, null, null, null);
                        boolean add = candidateList.addCandidate(createE);
                        if (!add) System.out.println("Failed to add candidate");
                        else System.out.println("Successfully added candidate");
                    } while (consoleForm.YN());
                    showAll();
                    break;
                case 2:
                    do {
                    Candidates basicInfo1 = consoleForm.createNewCandidates();
                    Fresher fresher = consoleForm.createNewFresher();
                    Candidates createC =candidateList.createCandidate(2,
                            basicInfo1.getFirstName(),
                            basicInfo1.getLastName(),
                            basicInfo1.getBirthdate(),
                            basicInfo1.getAddress(),
                            basicInfo1.getPhone(),
                            basicInfo1.getEmail(),
                            -1, null,
                            fresher.getGraduation_date(),
                            fresher.getGraduation_rank(),
                            fresher.getGraduation_From(),
                            null, null);
                        boolean add = candidateList.addCandidate(createC);
                        if (!add) System.out.println("Failed to add candidate");
                        else System.out.println("Successfully added candidate");
                    } while (consoleForm.YN());
                    showAll();
                    break;
                case 3:
                    do {
                    Candidates basicInfo2 = consoleForm.createNewCandidates();
                    Intern intern = consoleForm.createNewIntern();
                    Candidates createI = candidateList.createCandidate(3,
                            basicInfo2.getFirstName(),
                            basicInfo2.getLastName(),
                            basicInfo2.getBirthdate(),
                            basicInfo2.getAddress(),
                            basicInfo2.getPhone(),
                            basicInfo2.getEmail(),
                            -1, null, null, null,
                            intern.getUni_Name(),
                            intern.getMajors(), intern.getSemester());
                        boolean add = candidateList.addCandidate(createI);
                        if (!add) System.out.println("Failed to add candidate");
                        else System.out.println("Successfully added candidate");
                    } while (consoleForm.YN());
                    showAll();
                    break;
                case 4:
                    String[] i = consoleForm.searchCandidates();
                    List<Candidates> result = candidateList.searchCandidate(i[0], Integer.parseInt(i[1]));
                    String searchResult = candidateList.formatSearch(result);
                    consoleForm.displaySearch(searchResult);
                    break;
                case 5:
                    System.exit(0);

            }
        }
    }

    private void showAll(){
        consoleForm.printCandidates(candidateList.formatNames(0)
                , candidateList.formatNames(1)
                , candidateList.formatNames(2));
    }
}
