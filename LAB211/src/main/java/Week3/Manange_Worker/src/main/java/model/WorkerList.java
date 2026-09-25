package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class WorkerList {
    private final ArrayList<Worker> workerList = new ArrayList<>();

    public ArrayList<Worker> getWorkerList() {
        return workerList;
    }

    public void setWorkerList(Worker worker) {
        workerList.add(worker);
    }

    public boolean addWorker( Worker worker) {
        if ((findWorkerByCode(getWorkerList(), worker.getId()) == null)
                && (worker.getAge() >= 18 && worker.getAge() < 50)
                && worker.getSalary() > 0) {
            return workerList.add(worker);
        } else
            return false;

    }

    public Worker findWorkerByCode(List<Worker> list, String code) {
        for (Worker worker : list) {
            if (worker.getId().equals(code)) {
                return worker;
            }
        }
        return null;
    }

    public boolean changeSalary(String id, double amount, boolean isIncrease) {
        if (amount <= 0) return false;
        Worker worker = findWorkerByCode(workerList, id);
        if (worker == null) return false;
        if (isIncrease) worker.setSalary((int) (worker.getSalary() + amount));
        else if (amount >= worker.getSalary()) return false;
        else worker.setSalary((int) (worker.getSalary() - amount));
        String status = (isIncrease) ? "UP" : "DOWN";

        SalaryHistory history = new SalaryHistory(
                worker.getId(),
                worker.getName(),
                worker.getAge(),
                worker.getSalary(),
                status,
                LocalDate.now()
        );
        return worker.getHistoryList().add(history);
    }

    public List<SalaryHistory> getInformationSalary(){
        List<SalaryHistory> HistoryList = new ArrayList<>();
        for (Worker worker : workerList) {
            for (SalaryHistory history : worker.getHistoryList()) {
                if (history.getStatus().equals("-")) continue;
                HistoryList.add(history);
            }
        }
        HistoryList.sort(Comparator.comparing(SalaryHistory::getId));
        return HistoryList;
    }

    public String formatAll(List<SalaryHistory> list) {
        StringBuilder result = new StringBuilder();
        for (SalaryHistory c : list) {
            result.append(c.toString()).append("\n");
        }
        return result.toString();
    }
}
