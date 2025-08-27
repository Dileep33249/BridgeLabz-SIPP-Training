
// Pseudocode for College Course Registration
map<Course, List<Student>> courseMap;

addStudentToCourse(course, student) {
    if (!courseMap.containsKey(course)) {
        courseMap[course] = new List<Student>();
    }
    courseMap[course].add(student);
}

display() {
    for (course in courseMap.keys()) {
        print(course + ": " + courseMap[course]);
    }
}
