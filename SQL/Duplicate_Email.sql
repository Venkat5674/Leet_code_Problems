select p1.email as Email
from person p1
group by email
having count(email)>1

