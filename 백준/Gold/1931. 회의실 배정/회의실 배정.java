import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int n = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();
        int count = 0;
        PriorityQueue<Meeting> pq = new PriorityQueue<>((a,b) -> {
            if (a.end == b.end) {
                return a.start - b.start;
            }
            return a.end - b.end;
        });
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(bf.readLine());
            Meeting meeting = new Meeting(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
            pq.add(meeting);
        }
        int nowTime = 0;
        while (!pq.isEmpty()) {
            Meeting meeting = pq.poll();
            if (nowTime > meeting.start) {
                continue;
            }
            nowTime = meeting.end;
            count++;
        }
        System.out.println(count);
    }

    static class Meeting {
        int start ;
        int end;
        int duration;

        public Meeting(int start, int end) {
            this.start = start;
            this.end = end;
            this.duration = end - start;
        }
    }
}