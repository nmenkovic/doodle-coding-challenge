db.createUser({
  user: 'doodle',
  pwd: 'doodle',
  roles: [
    {
      role: 'readWrite',
      db: 'polls'
    }
  ]
})
